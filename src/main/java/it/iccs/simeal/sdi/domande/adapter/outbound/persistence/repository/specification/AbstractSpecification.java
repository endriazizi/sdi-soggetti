package it.iccs.simeal.sdi.domande.adapter.outbound.persistence.repository.specification;

import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class AbstractSpecification<ENTITY> extends QueryService<ENTITY> {

	protected Specification<ENTITY> applyEqualsFilter(Filter<? extends Serializable> filter, String fieldName) {
		return this.buildSpecification(filter, root -> root.get(fieldName));
	}

	/**
	 * @author aglieco salvatore
	 * @param <OTHER>
	 * @param <X>
	 * @param filter
	 * @param fieldName
	 * @param join
	 * @return
	 */
	protected <OTHER, X> Specification<ENTITY> applyJoinFilter(Filter<X> filter, String fieldName,
			Join<ENTITY, OTHER> join) {
		Specification<ENTITY> specification = Specification.where(null);
		if (filter != null) {
			specification = specification.or(this.buildSpecification(filter, root -> join.get(fieldName)));
		}
		return specification;
	}

	protected <OTHER> Specification<ENTITY> applyJoinEqualsFilter(UUID value, String fieldName,
			Join<ENTITY, OTHER> join) {
		Specification<ENTITY> specification = Specification.where(null);
		if (value != null) {
			UUIDFilter filter = new UUIDFilter();
			filter.setEquals(value);
			specification = specification.or(this.buildSpecification(filter, root -> join.get(fieldName)));
		}
		return specification;
	}

	protected Specification<ENTITY> applyInUUIDFilter(List<UUID> list, String fieldName) {
		Specification<ENTITY> specification = Specification.where(null);
		if (!list.isEmpty()) {
			UUIDFilter filter = new UUIDFilter();
			filter.setIn(list);
			specification = specification.or(buildSpecification(filter, root -> root.get(fieldName)));
		}
		return specification;
	}

	protected Specification<ENTITY> applyLocalDateFilter(List<LocalDateFilter> request,
			SingularAttribute<? super ENTITY, LocalDate> field) {
		Specification<ENTITY> specification = Specification.where(null);
		if (request != null && !request.isEmpty()) {
			for (RangeFilter<LocalDate> current : request) {
				specification = specification.or(buildRangeSpecification(current, field));
			}
		}
		return specification;
	}

	protected Specification<ENTITY> applyBooleanFilter(BooleanFilter request, String fieldName) {
		Specification<ENTITY> specification = Specification.where(null);
		if (request != null) {
			specification = specification.or(buildSpecification(request, root -> root.get(fieldName)));
		}
		return specification;
	}

	protected Specification<ENTITY> applyInFilter(List<UUID> list, String fieldName) {
		Specification<ENTITY> specification = Specification.where(null);
		if (!list.isEmpty()) {
			UUIDFilter filter = new UUIDFilter();
			filter.setIn(list);
			specification = specification.or(buildSpecification(filter, root -> root.get(fieldName)));
		}
		return specification;
	}

	protected Specification<ENTITY> applyInLongFilter(List<Long> list, String fieldName) {
		Specification<ENTITY> specification = Specification.where(null);
		if (!list.isEmpty()) {
			LongFilter filter = new LongFilter();
			filter.setIn(list);
			specification = specification.or(buildSpecification(filter, root -> root.get(fieldName)));
		}
		return specification;
	}

	protected <OTHER> Specification<ENTITY> applyJoinInFilter(List<UUID> list, String fieldName,
			Join<ENTITY, OTHER> join) {
		Specification<ENTITY> specification = Specification.where(null);
		if (!list.isEmpty()) {
			UUIDFilter filter = new UUIDFilter();
			filter.setIn(new ArrayList<>(list));
			specification = specification.or(buildSpecification(filter, root -> join.get(fieldName)));
		}
		return specification;
	}

	protected <OTHER> Specification<ENTITY> applyJoinFilterByHighestDate(String dateFieldName, String rootDistinctField,
			String joinDistinctField, Class<OTHER> joinClass, Join<ENTITY, OTHER> join) {
		return (Specification<ENTITY>) (root, query, cb) -> {
			Subquery<Instant> sq = query.subquery(Instant.class);
			Root<OTHER> sqRoot = sq.from(joinClass);
			sq.select(cb.greatest(sqRoot.<Instant>get(dateFieldName)))
					.where(cb.equal(root.get(rootDistinctField), sqRoot.get(joinDistinctField)));
			return cb.equal(join.get(dateFieldName), sq);
		};
	}

	protected Specification<ENTITY> applyFilterByHighestDate(String dateFieldName, String distinctField, Class _class) {
		return (Specification<ENTITY>) (root, query, cb) -> {
			Subquery<Instant> sq = query.subquery(Instant.class);
			Root sqRoot = sq.from(_class);
			sq.select(cb.greatest(sqRoot.<Instant>get(dateFieldName)))
					.where(cb.equal(root.get(distinctField), sqRoot.get(distinctField)));
			return cb.equal(root.get(dateFieldName), sq);
		};
	}

	protected Specification<ENTITY> applyLengthFilter(List<StringFilter> request, String fieldName) {
		return this.applyLengthFilter(request, fieldName, Collections.emptyList());
	}

	protected Specification<ENTITY> applyLengthFilter(List<StringFilter> request, String fieldName,
			List<String> reference) {
		Specification<ENTITY> specification = Specification.where(null);
		if (request != null && !request.isEmpty()) {
			for (StringFilter current : request) {
				if (!(this.hasAtLeastSize(current.getContains(), 3)
						|| this.hasAtLeastSize(current.getDoesNotContain(), 3))) {
					current.setContains(null);
					current.setDoesNotContain(null);
				}
				if (!reference.isEmpty()) {
					specification = specification
							.or(buildSpecification(current, root -> this.evaluatePath(root, reference).get(fieldName)));
				} else {
					specification = specification.or(buildSpecification(current, root -> root.get(fieldName)));
				}
			}
		}
		return specification;
	}
	
	// AGGIUNTO - FILTRA PER IL FLAG CON IL NOME ED IL VALORE DATO
	protected Specification<ENTITY> flagSpecification(String flagName, Short flagValue) {
	    return (grp, query, cb) -> cb.equal(grp.<Short>get(flagName), flagValue);
	}
	
	// AGGIUNTO - FUNZIONA - CONTROLLARE
	protected Specification<ENTITY> applyInIntegerFilter(List<Integer> list, String fieldName) {
		Specification<ENTITY> specification = Specification.where(null);
		if (!list.isEmpty()) {
			IntegerFilter filter = new IntegerFilter();
			filter.setIn(list);
			specification = specification.or(buildSpecification(filter, root -> root.get(fieldName)));
		}
		return specification;
	}
	
	// AGGIUNTO - NON FUNZIONA - TODO
	protected Specification<ENTITY> applyIntegerFilter(List<IntegerFilter> request, String fieldName) {	
		Specification<ENTITY> specification = Specification.where(null);
		if (request != null && !request.isEmpty()) {
			for (IntegerFilter  current : request) {
				specification = specification.or(buildSpecification(current, root -> root.get(fieldName)));
			}
		}
		return specification;
	}
	
	// AGGIUNTO - FUNZIONA - CONTROLLARE
	protected Specification<ENTITY> applyBigDecimalFilter(List<BigDecimalFilter> request, String fieldName) {	
		Specification<ENTITY> specification = Specification.where(null);
		if (request != null && !request.isEmpty()) {
			for (BigDecimalFilter  current : request) {
				specification = specification.or(buildSpecification(current, root -> root.get(fieldName)));
			}
		}
		return specification;
	}
	

	protected Specification<ENTITY> applySearchFilter(List<StringFilter> request, String fieldName) {
		return this.applySearchFilter(request, fieldName, Collections.emptyList());
	}

	protected Specification<ENTITY> applySearchFilter(List<StringFilter> request, String fieldName,
			List<String> reference) {
		Specification<ENTITY> specification = Specification.where(null);
		if (request != null && !request.isEmpty()) {
			for (StringFilter current : request) {
				if (!reference.isEmpty()) {
					specification = specification
							.or(buildSpecification(current, root -> this.evaluatePath(root, reference).get(fieldName)));
				} else {
					specification = specification.or(buildSpecification(current, root -> root.get(fieldName)));
				}
			}
		}
		return specification;
	}



	protected <OTHER> Specification<ENTITY> applySearchJoinFilter(List<StringFilter> request, String fieldName,
			Join<ENTITY, OTHER> join) {
		Specification<ENTITY> specification = Specification.where(null);
		if (request != null && !request.isEmpty()) {
			for (StringFilter current : request) {
				specification = specification.or(buildSpecification(current, root -> join.get(fieldName)));
			}
		}
		return specification;
	}

	private Path<?> evaluatePath(Root<ENTITY> root, List<String> references) {
		Path<?> calc = root.get(references.get(0));
		for (String r : references.subList(1, references.size())) {
			calc = calc.get(r);
		}
		return calc;
	}

	private boolean hasAtLeastSize(String aString, int size) {
		return StringUtils.isNotBlank(aString) && aString.length() >= size;
	}

	protected Specification<ENTITY> applyInStringFilter(List<String> list, String fieldName) {
		Specification<ENTITY> specification = Specification.where(null);
		if (!list.isEmpty()) {
			StringFilter filter = new StringFilter();
			filter.setIn(list);
			specification = specification.or(buildSpecification(filter, root -> root.get(fieldName)));
		}
		return specification;
	}
	
    protected Specification<ENTITY> applyUUIDSearchFilter(UUIDFilter uf, String fieldName, List<String> reference) {
        Specification<ENTITY> specification = Specification.where(null);
        if (uf != null)  {
        	if (!reference.isEmpty()) {
                specification = specification.or(buildSpecification(uf, root -> this.evaluatePath(root, reference).get(fieldName)));
            } else {
                specification = specification.or(buildSpecification(uf, root -> root.get(fieldName)));
            }
        }
        return specification;
    }
    
    // ------------------------------------------------------------------------------------------------
    
    // Aggiunge un filtro IN ad una JION tra 2 qualsiasi entity, ENTITY1, ENTITY2
    protected <ENTITY1, ENTITY2> Specification<ENTITY> applyJoinInFilterGeneric(List<UUID> list, String fieldName,
			Join<ENTITY1, ENTITY2> join) {
		Specification<ENTITY> specification = Specification.where(null);
		if (!list.isEmpty()) {
			UUIDFilter filter = new UUIDFilter();
			filter.setIn(new ArrayList<>(list));
			specification = specification.or(buildSpecification(filter, root -> join.get(fieldName)));
		}
		return specification;
	}
	
}

