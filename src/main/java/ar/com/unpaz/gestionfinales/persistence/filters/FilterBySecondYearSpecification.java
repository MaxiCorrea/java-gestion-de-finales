package ar.com.unpaz.gestionfinales.persistence.filters;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.persistence.SubjectSpecification;

public class FilterBySecondYearSpecification implements SubjectSpecification {

  @Override
  public boolean specified(Subject subject) {
    return subject.getYear() == 2;
  }

}