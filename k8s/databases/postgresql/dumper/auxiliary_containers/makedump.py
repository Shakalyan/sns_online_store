import os
from datetime import date

psql_host = os.environ['HOST']
database = os.environ['DATABASE']
user = os.environ['USER']
password = os.environ['PASSWORD']
dumps_path = os.environ['DUMPS_PATH']
hosts = set(os.environ['REPLICA_HOSTS'].split(','))

dump_name = f'psql-dump-{date.today()}'
os.system(f'PGPASSWORD="{password}" pg_dump -h {psql_host} -U {user} {database} > {dump_name}')
if os.path.isfile(dump_name):
    for host in hosts:
        os.system(f"scp -o StrictHostKeychecking=no {dump_name} root@{host}:{dumps_path}/{dump_name}")
    print(f'{dump_name} successfully created')
else:
    print('Dump creation failed')
