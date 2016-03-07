package aron.sinoai.springmvcjpa.spring;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("testHello")
public class HelloController {
	private static final Logger LOGGER = LogManager.getLogger(HelloController.class);

	public static final String MESSAGE_PARAMETER_TAG = "message";

	public static final String HELLO_VIEW_TAG = "hello";

	public static final String SAMPLE_TEXT = "Hello world!";

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(final ModelMap model) {
		LOGGER.info("lala");

		model.addAttribute(MESSAGE_PARAMETER_TAG, SAMPLE_TEXT);
		return HELLO_VIEW_TAG;
	}
}