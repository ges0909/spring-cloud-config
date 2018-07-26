# Spring Config

1. Start client and test with `curl http://localhost:8080/message`. Result should be the default message.
1. Start server.

## Git repo

```bash
mkdir config-repo && cd config-repo
git init
touch my-config-client-development.yml
touch my-config-client-production.yml
...
git add my-config-client-development.yml
git add my-config-client-production.yml
git commit -m "initial config"
```

Test the client.

* `curl http://localhost:8080/message`

Test the server.

* `curl http://localhost:8888/my-config-client/default`
* `curl http://localhost:8888/my-config-client/DEV`
