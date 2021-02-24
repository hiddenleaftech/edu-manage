package com.hiddenleaf.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;
import com.hiddenleaf.domain.QRouteContact;
import com.hiddenleaf.domain.RouteContact;
import com.hiddenleaf.repository.RouteContactRepository;
import com.hiddenleaf.util.FileConstant;
import com.hiddenleaf.util.StringUtil;

@RestController
@RequestMapping("/api")
public class RouteContactResource implements FileConstant {

	private static final Logger log = LoggerFactory.getLogger(RouteContactResource.class);

	@Autowired
	RouteContactRepository routeContactRepository;

	@GetMapping("/routecontact/search")
	List<RouteContact> getAll() throws Exception {
		return searchR(null);
	}

	@PostMapping("/routecontact/search")
	List<RouteContact> searchRouteContact(@RequestBody RouteContact rcSearch) throws Exception {
		return searchR(rcSearch);
	}

	private List<RouteContact> searchR(RouteContact rcSearch) {

		if (rcSearch != null) {
			String id = rcSearch.getId();
			String source = rcSearch.getSource();
			String destination = rcSearch.getDestination();

			QRouteContact qRouteContactDTO = QRouteContact.routeContact;
			BooleanBuilder booleanBuilder = new BooleanBuilder();

			if (!StringUtil.isNullOrEmpty(id)) {

				booleanBuilder.and(qRouteContactDTO.id.eq(id));
			}

			if (!StringUtil.isNullOrEmpty(source)) {
				booleanBuilder.and(qRouteContactDTO.source.eq(source));
			}

			if (!StringUtil.isNullOrEmpty(destination)) {
				booleanBuilder.and(qRouteContactDTO.destination.eq(destination));
			}

			if (booleanBuilder.getValue() != null) {
				Iterable<RouteContact> routeIterable = routeContactRepository.findAll(booleanBuilder.getValue());
				if (routeIterable != null) {
					return Lists.newArrayList(routeIterable);
				}
			} else {
				Iterable<RouteContact> routeIterable = routeContactRepository.findAll();
				if (routeIterable != null) {
					return Lists.newArrayList(routeIterable);
				}
			}
		} else {
			Iterable<RouteContact> routeIterable = routeContactRepository.findAll();
			if (routeIterable != null) {
				return Lists.newArrayList(routeIterable);
			}
		}

		return null;
	}

}
