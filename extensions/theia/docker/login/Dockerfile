FROM node:8.14.0-stretch AS com.yakindu.solidity.web.login
LABEL maintainer="itemis AG"

# Execute as root to run apt-get; can't use sudo
USER root
WORKDIR /

#Switch to User docker
RUN chmod -R 777 /usr/local && useradd -ms /bin/bash docker
USER docker
WORKDIR /home/docker

# Get sourcen an remove unneeded ones
RUN git clone https://github.com/fspiekermann/solidity-ide.git --branch feature/theia_integration
RUN cp -r solidity-ide/extensions/theia/login ./login
RUN rm -rf solidity-ide/

#compile sources
WORKDIR /home/docker/login
RUN touch data.csv
RUN npm install -D ts-node
RUN npm install -D typescript
RUN npm i

# Startup
EXPOSE 4242 
CMD npm run parallel