import os
import shutil

def mover_arquivo(origem, destino):
    try:
        if not os.path.exists(origem):
            print(f"Erro: o arquivo '{origem}' não existe.")
            return

        if not os.path.exists(destino):
            os.makedirs(destino)

        nome_arquivo = os.path.basename(origem)
        caminho_destino = os.path.join(destino, nome_arquivo)

        shutil.move(origem, caminho_destino)
        print(f"Arquivo movido com sucesso para: {caminho_destino}")

    except Exception as e:
        print(f"Ocorreu um erro ao mover o arquivo: {e}")

if __name__ == "__main__":
    origem = input("Digite o caminho completo do arquivo de origem: ")
    destino = input("Digite o caminho da pasta de destino: ")
    mover_arquivo(origem, destino)
