# java_ibm
Configuração e instalação do springBoot
*************************
  ```INSTALAÇÕES E CONFIGURAÇÕES

   instalações e comandos no console é a primeira (https://www.youtube.com/watch?v=OXbPZPmt2ys)
   
  configurações de variáveis de ambiente, java (jdk) na máquina:  https://www.youtube.com/watch?v=xzAESAp_soQ
  
   -> para verificar se deu certo, no console cmd dar o comando: java -version
   
 instalar e configurar variáveis de ambiente maven na máquina:  https://www.youtube.com/watch?v=-ucX5w8Zm8s 
 
   -> para verificar se deu certo, no console cmd dar o comando: mvn -version
     ```
*************************
CRIANDO O PROJETO
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
 para autorizar a execução do nosso arquivo start.sh, no console gitbash escrever o comando:
   -> chmod +x start.sh
  no console gitbash, escrever o comando:
   -> ./start.sh
***********************
SUBINDO NOSSA APLICAÇÃO PARA O GITHUB
 - Adicionar itens ao nosso gitignore (fica na pasta do projeto), utilizando o site gititnore.io (https://www.toptal.com/developers/gitignore/api/windows,linux,macos,eclipse,vs,intellij)
   -> copiar e colar tudo isso no nosso arquivo gitignore
 - Adicionar também os logs do maven:
   .mvn
   mvnw
   mvnw.cmd
   ***********************
