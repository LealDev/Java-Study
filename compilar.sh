#!/bin/bash
#
# Configuração de caminhos
#
SRC="src"
BIN="bin"

# Criar diretório de saída
mkdir -p "$BIN"

# Compilar o arquivo java
javac -d "$BIN" "$SRC"/*.java

# Verificar se houver erro na compilação
if [ $? -ne 0 ]; then
  echo "Erro ao compilar o arquivo Java!"
  exit 1
fi

echo "Compilação concluída!"

# Executar o programa (se tiver em um pacote, ajuste o caminho)
java -cp "$BIN" Main
