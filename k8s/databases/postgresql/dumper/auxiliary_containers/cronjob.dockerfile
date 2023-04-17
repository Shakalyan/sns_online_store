FROM python:3.8

ENV TZ=Europe/Moscow

COPY keys/* /root/.ssh/

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone \
&& apt update \
&& apt upgrade -y \
&& apt install gnupg2 wget curl lsb-release -y \
&& sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list' \
&& wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add - \
&& apt update -y \
&& apt install -y postgresql-15 openssh-client \
&& chmod 600 /root/.ssh/id_rsa \
&& chmod 600 /root/.ssh/id_rsa.pub

COPY makedump.py /

