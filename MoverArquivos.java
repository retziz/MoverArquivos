import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class MoverArquivos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuario = System.getProperty("user.name");

        System.out.println("=== Sistema de Gerenciamento de Arquivos - MOVER ===");
        System.out.println("Usuário logado: " + usuario);

        System.out.print("Informe o caminho do arquivo que deseja mover: ");
        String origem = scanner.nextLine();

        System.out.print("Informe o novo caminho de destino: ");
        String destino = scanner.nextLine();

        try {
            Path pathOrigem = Paths.get(origem);
            Path pathDestino = Paths.get(destino);

            // Verifica se o arquivo de origem existe
            if (!Files.exists(pathOrigem)) {
                System.out.println("O arquivo de origem não existe.");
                return;
            }

            // Verifica se o diretório de destino existe
            if (!Files.exists(pathDestino.getParent())) {
                System.out.println("O diretório de destino não existe.");
                return;
            }

            Files.move(pathOrigem, pathDestino, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Arquivo movido com sucesso!");
            salvarLog("Movido de: " + origem + " para: " + destino, usuario);
        } catch (IOException e) {
            System.out.println("Erro ao mover o arquivo: " + e.getMessage());
        }
    }

    public static void salvarLog(String mensagem, String usuario) {
        String log = "Usuário: " + usuario + " | Ação: " + mensagem + " | Data: " + java.time.LocalDateTime.now() + "\n";
        try {
            Files.write(Paths.get("log.txt"), log.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao salvar log.");
        }
    }
}
