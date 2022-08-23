# java_ibm
Configuração e instalação do springBoot
*************************
INSTALAÇÕES E CONFIGURAÇÕES
0 - Acompanhar o passo a passo do professor nas aulas extras.
   A indicação é ver toda a playlist no site do prof. Danilo (https://www.torneseumprogramador.com.br/aulas/java).
   A aula em que ensina essas instalações e comandos no console é a primeira (https://www.youtube.com/watch?v=OXbPZPmt2ys)
   Caso queira, nos itens 1 e 2 abaixo listei outros dois passo-a-passo detalhados sobre instalação e configurações de variáveis de ambiente.
1 - instalar e configurar variáveis de ambiente java (jdk) na máquina:  https://www.youtube.com/watch?v=xzAESAp_soQ
   -> para verificar se deu certo, no console cmd dar o comando: java -version
2 - instalar e configurar variáveis de ambiente maven na máquina:  https://www.youtube.com/watch?v=-ucX5w8Zm8s 
   -> para verificar se deu certo, no console cmd dar o comando: mvn -version
*************************
CRIANDO O PROJETO
3 - criar um projeto no spring initializr (site start.spring.io). Não precisa adicionar nenhuma dependência.
   Group: com.br.danilo.
   Artifact:  console.
   Name: console.
   Description: Um projeto para trabalhar com lógica e orientação a objetos.
4 - clicar em "generate", baixar e descompactar o arquivo .zip do projeto.
5 - abrir a pasta no console gitbash e no vscode. Caso queira, é possível configurar o console gitbash no próprio vs code.
6 - no console gitbash, na pasta do projeto, dar o comando: mvn spring-boot:start
7 - para não esquecer esse comando: pelo vscode, na pasta do projeto, criar um arquivo README.md, com o texto a seguir
   ```shell
   mvn spring-boot: start #rodando com o maven instalado no computador #rodando com o maven instalado no computador
   ./mvnw spring-boot:start #roda com unix e o binário do maven na pasta oculta .mvn -> gitbash e subsystem (ubuntu dentro do windows)
   mvnw.cmd spring-boot:start # roda com MSDos(windows) e o binário do maven na pasta oculta .mvn.
   ```
8 - no console gitbash: limpar as informações do maven e reinstalar as suas dependencias no computador.
   -> comando: mvn clean
9 - gerar o arquivo .jar, no console gitbash dar os seguintes comandos:
   -> mvn package
   -> java -jar targed/console-0.0.1-SNAPSHOT.jar
*************************
AUTOMATIZANDO ESSE PROCESSO COM SHELLSCRIPT
10 - no vscode, na pasta raiz do projeto, criar o arquivo start.sh, com o seguinte texto
   mvn clean
//gerar o binario
   mvn package
//compliar o meu harquivo final
   java -jar target/console-0.0.1-SNAPSHOT.jar
11 - para autorizar a execução do nosso arquivo start.sh, no console gitbash escrever o comando:
   -> chmod +x start.sh
12 - no console gitbash, escrever o comando:
   -> ./start.sh
***********************
SUBINDO NOSSA APLICAÇÃO PARA O GITHUB
13 - adicionar itens ao nosso gitignore (fica na pasta do projeto), utilizando o site gititnore.io (https://www.toptal.com/developers/gitignore/api/windows,linux,macos,eclipse,vs,intellij)
   -> copiar e colar tudo isso no nosso arquivo gitignore
14 - no nosso arquivo gitignore, vamos adicionar também os logs do maven. Escrever o texto:
   .mvn
   mvnw
   mvnw.cmd
15 - Criar um repositorio no github e dar os seguintes comandos:
   git init
   git commit -m "iniciando projeto com spring no console"
   git remote add origin <link do repositorio no github>
   git branch -m main
   git push -u origin main
