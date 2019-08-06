package hello;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileBuffer;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.upload.receivers.MultiFileBuffer;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.vaadin.olli.FileDownloadWrapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

@Route(JobApplyView.NAME)
public class JobApplyView extends VerticalLayout {
    public static final String NAME = "apply";

    private final ApplicantService applicantService;
    private final JobRepository jobRepository;
    private final CurrentUserRepo currentUserRepo;
    private final JobApplicationRepo jobApplicationRepo;

    private TextField firstName = new TextField("First Name");
    private TextField lastName = new TextField("Last Name");
    private TextField email = new TextField("Email");

    Binder<JobApplication> binder = new Binder<>(JobApplication.class);
    private Button submit = new Button("Submit");

    private InputStream inputStream;
    private byte[] fileBytes;

    private ArrayList<String> files = new ArrayList<>();

    public JobApplyView(ApplicantService applicantService,
                        JobRepository jobRepository,
                        CurrentUserRepo currentUserRepo,
                        DocumentRepository documentRepository,
                        JobApplicationRepo jobApplicationRepo) throws IOException {
        this.applicantService = applicantService;
        this.jobRepository = jobRepository;
        this.currentUserRepo = currentUserRepo;
        this.jobApplicationRepo = jobApplicationRepo;

//        MemoryBuffer buffer = new MemoryBuffer();
        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);
//        upload.setAcceptedFileTypes(".pdf", ".txt", ".doc", ".docx");
        upload.addFinishedListener(e -> {
            for (String fileName : buffer.getFiles()) {
                inputStream = buffer.getInputStream(fileName);
//            buffer.getFileName();
                try {
                    fileBytes = ArrayUtils.addAll(fileBytes, inputStream.readAllBytes());
                } catch (IOException ex) {
                    System.out.println("Download Error");
                }
            }

            Button download = new Button("Download");
            FileDownloadWrapper buttonWrapper = new FileDownloadWrapper(new StreamResource("document.pdf",
                    () -> new ByteArrayInputStream(fileBytes)));
            buttonWrapper.wrapComponent(download);
            add(buttonWrapper);
        });

        binder.bindInstanceFields(this);

        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        submit.addClickListener(event -> apply());

        add(firstName, lastName, email, new H3("Upload required documents: "), upload);
    }

    public void apply() {
        // auto-fill names/email above (write code above)
        // pass JobApplication's ID here at ui.switchViews (for the applied/applying fields of Applicant)
        // save uploaded documents in repo
        // save application details in repo
        // pass ids of new application and documents to ApplicantService
        // ApplicantService will use setters to modify Applicant applicant, then save it in ApplicantRepo
    }
}
