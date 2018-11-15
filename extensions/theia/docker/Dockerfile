FROM debian:stretch AS com.yakindu.solidity.web.ide
MAINTAINER "itemis"

# Execute as root to run apt-get; can't use sudo
USER root
WORKDIR /

# Prepare image
RUN apt-get update
RUN apt-get install gnupg2 --assume-yes
RUN apt-get install git --assume-yes
RUN apt-get install make --assume-yes
RUN apt-get install curl --assume-yes
RUN apt-get install gcc --assume-yes
RUN apt-get install g++ --assume-yes
RUN apt-get install openjdk-8-jdk --assume-yes
RUN apt-get install maven --assume-yes
RUN curl -sL https://deb.nodesource.com/setup_8.x | bash -
RUN apt-get install -y nodejs --assume-yes
RUN curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -
RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list
RUN apt-get update && apt-get install yarn --assume-yes

#Switch to User docker
RUN chmod -R 777 /usr/local && useradd -ms /bin/bash docker
USER docker
WORKDIR /home/docker

# Get & build theia IDE (After pull Request switch to main repository)
RUN git clone https://github.com/fspiekermann/solidity-ide.git --branch feature/theia_integration
RUN cd solidity-ide/releng/com.yakindu.solidity.releng && mvn clean install
RUN cd solidity-ide/extensions/theia/ && yarn install

# Startup
EXPOSE 8080 
CMD cd /home/docker/solidity-ide/extensions/theia/app && yarn start