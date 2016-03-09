package aron.sinoai.springmvcjpa.common.repository;


import aron.sinoai.springmvcjpa.common.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IShopRepository extends JpaRepository<Shop, Integer> {

}