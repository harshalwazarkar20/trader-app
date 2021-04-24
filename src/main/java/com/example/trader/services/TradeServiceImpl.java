package com.example.trader.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trader.dto.TradeCreateRequest;
import com.example.trader.dto.TradeResponse;
import com.example.trader.dto.TradeUpdateRequest;
import com.example.trader.dto.TraderFindResponse;
import com.example.trader.entity.Trade;
import com.example.trader.repository.TradeRepository;

@Service
public class TradeServiceImpl implements TraderService {
	
	private TradeRepository tradeRepository;
	
	@Autowired
	public TradeServiceImpl(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}
	
	@Override
	public TradeResponse create(TradeCreateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<TraderFindResponse> getAll() {
		List<Trade> response = tradeRepository.findAll();
		return response.stream().map(t -> {
			TraderFindResponse resp = new TraderFindResponse();
			resp.setBookId(t.getBookId());
			resp.setCounterPartyId(t.getCounterPartyId());
			resp.setCreatedDate(t.getCreatedDate());
			resp.setExpired(t.getExpired());
			resp.setId(t.getId());
			resp.setMaturityDate(t.getMaturityDate());
			resp.setVersion(t.getVersion());
			return resp;
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<TraderFindResponse> findById(Long id) {
		Optional<Trade> response = tradeRepository.findById(id);
		return response.map(t -> {
			TraderFindResponse resp = new TraderFindResponse();
			resp.setBookId(t.getBookId());
			resp.setCounterPartyId(t.getCounterPartyId());
			resp.setCreatedDate(t.getCreatedDate());
			resp.setExpired(t.getExpired());
			resp.setId(t.getId());
			resp.setMaturityDate(t.getMaturityDate());
			resp.setVersion(t.getVersion());
			return resp;
		});
		
	}

	@Override
	public TradeResponse update(TradeUpdateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
