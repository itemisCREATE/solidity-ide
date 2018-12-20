FROM node:8.14.0-stretch AS com.yakindu.solidity.web.ide
LABEL maintainer="itemis AG"

# Execute as root to run apt-get; can't use sudo
USER root
WORKDIR /

# Prepare image
RUN apt-get update
RUN apt-get install openjdk-8-jdk --assume-yes
RUN apt-get install maven --assume-yes
RUN npm install yarn

#Switch to User docker
RUN chmod -R 777 /usr/local && useradd -ms /bin/bash docker
USER docker
WORKDIR /home/docker

# Get & build theia IDE (After pull Request switch to main repository)
RUN git clone https://github.com/fspiekermann/solidity-ide.git --branch feature/theia_integration
RUN cd solidity-ide/releng/com.yakindu.solidity.releng && mvn clean install
RUN cp -r solidity-ide/plugins/com.yakindu.solidity.ide/target/languageserver ./lsp
RUN cp -r solidity-ide/extensions/theia ./theia
RUN sed -i -r 's;(.*)cp -r .\/..\/..\/..\/plugins\/com.yakindu.solidity.ide\/target\/languageserver\/\* .\/lsp\/",;\1cp -r /home/docker/lsp/* ./lsp",;' /home/docker/theia/xtext-dsl-extension/package.json
RUN rm -rf solidity-ide/
RUN cd theia/ && yarn install

# Startup
EXPOSE 8080 
CMD cd /home/docker/theia/app && yarn start
