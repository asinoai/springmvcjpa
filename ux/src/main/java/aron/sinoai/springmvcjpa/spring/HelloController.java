package aron.sinoai.springmvcjpa.spring;


import aron.sinoai.springmvcjpa.common.entities.Shop;
import aron.sinoai.springmvcjpa.common.repository.IShopRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


@Service
@Controller
public class HelloController {

	public static final String MESSAGE_PARAMETER_TAG = "message";

	public static final String HELLO_VIEW_TAG = "hello";

	public static final String SAMPLE_TEXT = "Hello world!";

    private static final Logger LOGGER = LogManager.getLogger(HelloController.class);

    @Resource
    private IShopRepository shopRepository;

    @Transactional
    @RequestMapping(path = "testHello", method = RequestMethod.GET)
    public String printWelcome(final ModelMap model) {
		LOGGER.info("welcome!");

		final Shop entity = new Shop();
        entity.setName("test");
        entity.setEmplNumber(1);
        final Shop savedEntity = shopRepository.save(entity);

        model.addAttribute(MESSAGE_PARAMETER_TAG, SAMPLE_TEXT);
		return HELLO_VIEW_TAG;
	}

    @RequestMapping(value = "fileDownload", method = RequestMethod.POST)
    public ResponseEntity<InputStreamResource> downloadFile(final String sequenceID) throws FileNotFoundException {

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        final String filename = "output" + sequenceID + ".pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        InputStream samplePDFStream = new FileInputStream("/Users/aronsinoai/Downloads/6145888.pdf");

        final InputStreamResource resource = new InputStreamResource(samplePDFStream);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

}