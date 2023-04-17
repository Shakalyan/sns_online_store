FROM ubuntu:22.04

RUN apt update -y \
&& apt upgrade -y \
&& apt install openssh-server -y \
&& service ssh start

COPY keys/id_rsa.pub /root/.ssh/authorized_keys

CMD ["/bin/sh" , "-c", "tail -f /dev/null"]
