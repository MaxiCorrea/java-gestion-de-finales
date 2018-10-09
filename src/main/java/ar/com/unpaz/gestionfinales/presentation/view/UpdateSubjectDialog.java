package ar.com.unpaz.gestionfinales.presentation.view;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;

public interface UpdateSubjectDialog {

  void setSubject(Subject selected);

  void setController(DialogController controller);

  void show();

  void close();

  Subject getSubject();

}