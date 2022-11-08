package kh.sellermoon.member.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.member.dao.CartDao;
import kh.sellermoon.member.dao.PCartDao;
import kh.sellermoon.member.dao.ProductDao;
import kh.sellermoon.member.vo.CartVO;
import kh.sellermoon.member.vo.MdVO;

@Service
public class PCartLogic {
	Logger logger = LoggerFactory.getLogger(PCartLogic.class);

	@Autowired
	private PCartDao pCartDao;

	public List<CartVO> getAllCartsVO(Map<String, Object> pMap) throws Exception {
		return pCartDao.getAllCartsVO(pMap);
	}

	public void insertCart(Map<String, Object> pMap) throws Exception {
		logger.info("pmap1:" + pMap);
		// 장바구니에 담긴 특정 상품 개수, cartNo 조회
		Map<String, Object> existMap = pCartDao.existMdInCart(pMap);
		logger.info("existMap0:" + existMap);
		// 이미 장바구니에 해당 상품이 존재한다면
		if(existMap != null) {
			// cnt = 이미 장바구니에 담은 해당 상품 갯수
			int cnt =  Integer.parseInt(existMap.get("CARTQUANTITY").toString()); 
			logger.info("cnt:" + cnt);
			// 새로 담으려는 상품 갯수
			int quantity = Integer.parseInt(pMap.get("cartQuantity").toString()); 
			logger.info("quantity:" + quantity);
			
			// quantity = quantity + cnt
			quantity += cnt; 

			pMap.put("quantity", quantity);
			pMap.put("cartNo", existMap.get("CARTNO"));
			
			logger.info("existMap:" + existMap);
			logger.info("pmap2:" + pMap);
			
			pCartDao.updateCart(pMap);
			
		} else {
			pCartDao.insertCart(pMap);
		}
	}

	public void updateCart(Map<String, Object> cartMap) throws Exception {
		pCartDao.updateCart(cartMap);

	}

	public void deleteCart(Map<String, Object> cartMap) throws Exception {
		pCartDao.deleteCart(cartMap);
	}
}
