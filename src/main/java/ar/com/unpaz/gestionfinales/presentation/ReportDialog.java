package ar.com.unpaz.gestionfinales.presentation;

import java.io.File;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface ReportDialog extends Dialog {

  void setController(DialogController controller);

  File getFile();

}
