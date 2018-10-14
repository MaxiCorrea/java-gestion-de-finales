package ar.com.unpaz.gestionfinales.plaintext;

import static java.lang.String.valueOf;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.reports.ReportException;
import ar.com.unpaz.gestionfinales.reports.Report;

public class PlainTextSubjectReport implements Report {

  @Override
  public void generateReport(String absolutePath) throws ReportException {
    try (FileWriter out = new FileWriter(absolutePath);
        BufferedWriter buffer = new BufferedWriter(out)) {
      for (Subject subject : AppRepositoryContext.subjectRepository.getAll()) {
        buffer.write(valueOf(subject.getId()));
        buffer.write("\t");
        buffer.write(subject.getDescription());
        buffer.write("\t");
        buffer.write(valueOf(subject.getYear().number));
        buffer.write("\t");
        buffer.newLine();
      }
    } catch (IOException exception) {
      throw new ReportException();
    }
  }

}