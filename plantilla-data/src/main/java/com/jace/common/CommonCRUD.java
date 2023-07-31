package com.jace.common;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public class CommonCRUD<E, R extends PagingAndSortingRepository<E, Long>>{

//	@Autowired
//	protected R repository;
//
//	public List<E> findAllPaging(int page, int size, String sort){
//		Pageable p = PageRequest.of(page, size, Sort.by(sort));
//		Page<E> data = this.repository.findAll(p);
//		return data.getContent();
//	}
//
//	public E save(E e) {
//		return this.repository.save(e);
//	}
//
//	public E update(E e) {
//		return this.repository.save(e);
//	}
//
//	public void delete(E e) {
//		this.repository.delete(e);
//	}
//
//	public Optional<E> findOne(Long id) {
//		return this.repository.findById(id);
//	}

//	public List<E> findByCriteria(Map<String, Object> fields, String[] order){
//		return this.repository.findAll(new Specification<E>() {
//			@Override
//			public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				List<Predicate> predicates = new ArrayList<>();
//
//				if (fields != null) {
//					predicates = getParametersFilter(criteriaBuilder, root, fields);
////					criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
//				}
//
//				if (order != null)
//					query.orderBy((order[1].equalsIgnoreCase("DESC")) ? criteriaBuilder.desc(root.get(order[0])) : criteriaBuilder.asc(root.get(order[0])));
//
//				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
//			}
//		});
//	}
//
//	public List<Predicate> getParametersFilter(CriteriaBuilder builder, Root<E> root, Map<String, Object> filters) {
//		List<Predicate> predicates = new ArrayList<>();
//
//		if (filters != null && !filters.isEmpty()) {
//			filters.forEach((k, v) -> {
//				predicates.add(builder.equal(root.get(k), filters.get(k)));
//			});
//		}
//		return predicates;
//	}
}