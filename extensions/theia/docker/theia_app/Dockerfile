FROM node:8.14.0-stretch AS com.yakindu.solidity.web.ide
LABEL maintainer="itemis AG"

# Execute as root to run apt-get; can't use sudo
USER root
WORKDIR /

# Prepare image
RUN apt-get update
RUN apt-get install openjdk-8-jdk --assume-yes
RUN apt-get install maven --assume-yes
RUN npm install --global yarn

#Switch to User node
USER node
WORKDIR /home/node
COPY languageserver ./lsp
COPY ide ./theia

# Get & build theia IDE
RUN sed -i -r 's;(.*)cp -r ..\/..\/..\/..\/plugins\/com.yakindu.solidity.ide\/target\/languageserver\/\* .\/lsp\/",;\1cp -r /home/node/lsp/* ./lsp",;' /home/node/theia/xtext-dsl-extension/package.json

WORKDIR /home/node/theia
RUN yarn install

# Startup
EXPOSE 8080 
CMD cd ./app && yarn start
