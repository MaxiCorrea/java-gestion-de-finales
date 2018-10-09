package ar.com.unpaz.gestionfinales.presentation.view;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.model.YearCombo;

public interface SubjectView {

  void show();

  void update(List<Subject> subjects);

  YearCombo getSelectedYear();

  
  /// ----- 
  
  String getDescription();

  int getYear();

  void showDialog();

  void closeDialog();

  void clearDescription();

  void resetYear();

  void message(String message);

}
