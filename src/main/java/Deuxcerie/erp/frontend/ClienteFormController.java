package Deuxcerie.erp.frontend;

import Deuxcerie.erp.backend.database_structure.Cliente;
import Deuxcerie.erp.backend.repositories.ClienteRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.springframework.boot.autoconfigure.mail.MailSenderValidatorAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class ClienteFormController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField telefoneField;

    @FXML
    private TextField idadeField;

    @FXML
    private Button salvarButton;

    private final ClienteRepository clienteRepository;

    public ClienteFormController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @FXML
    public void initialize() {
        salvarButton.setOnAction(e -> salvarCliente());
    }

    private void salvarCliente() {
        String nome = nomeField.getText().trim();
        String email = emailField.getText().trim();
        String telefone = telefoneField.getText().trim();
        String idadeTexto = idadeField.getText().trim();

        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || idadeTexto.isEmpty()) {
            showAlert("Erro", "Todos os campos devem ser preenchidos!", AlertType.ERROR);
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeTexto);
        } catch (NumberFormatException e) {
            showAlert("Erro", "Idade deve ser um número válido!", AlertType.ERROR);
            return;
        }

        String emailRegex = "[-A-Za-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-A-Za-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?";

        if (!email.matches(emailRegex)) {
            showAlert("Erro", "Email invalido!", AlertType.ERROR);
            return;
        }

        if (clienteRepository.findByEmail(email).isPresent()) {
            showAlert("Erro", "Email já consta na base.", AlertType.ERROR);
            return;
        }

        try {
            Cliente cliente = new Cliente(nome, email, telefone, idade);
            clienteRepository.save(cliente);
            showAlert("Sucesso", "Cliente salvo com sucesso!", AlertType.INFORMATION);
        } catch (Exception e) {
            showAlert("Erro", "Nao foi possivel salvar o cliente!", AlertType.ERROR);
        }

        // Limpar campos
        nomeField.clear();
        emailField.clear();
        telefoneField.clear();
        idadeField.clear();
    }

    private void showAlert(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
