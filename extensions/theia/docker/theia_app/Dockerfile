FROM node:10.16.0-stretch-slim AS com.yakindu.solidity.web.ide
LABEL maintainer="itemis AG"

RUN echo "deb http://deb.debian.org/debian stretch-backports main" >> /etc/apt/sources.list

# see https://github.com/puckel/docker-airflow/issues/182#issuecomment-444683455
# see https://bugs.debian.org/cgi-bin/bugreport.cgi?bug=863199
RUN mkdir -p /usr/share/man/man1

# Prepare image
RUN apt-get update; \
  apt-get -t stretch-backports install \
  -y --no-install-recommends \
  openjdk-8-jre-headless \
  make \
  g++ \
  python

# Startup
EXPOSE 8080 
CMD cd ./app && yarn start
