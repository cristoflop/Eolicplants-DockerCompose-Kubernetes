const { spawnSync } = require('child_process');

function exec(serviceName, command){

  console.log(`Starting docker image for [${serviceName}]`);
  console.log(`Command: ${command}`);

  spawnSync(command, [], {

    shell: true,
    stdio: 'inherit'
  });
}

exec('MongoDB', 'docker run --rm -d -p 27017-27019:27017-27019 --name mongodb mongo');
exec('MySQL', 'docker run --rm -d -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=eoloplantsDB -p 3306:3306 --name mysql mysql:8.0.22');
exec('RabbitMQ', 'docker run --rm -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:3-management');
