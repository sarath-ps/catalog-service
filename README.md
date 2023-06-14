# Cloud Native Application-1

```bash
$ source <(kubectl completion zsh)
$ cd ~/Learn/CloudNative/catalog-service
$ minikube image load catalog-service:0.0.1-SNAPSHOT
$ kubectl create deployment catalog-service --image=catalog-service:0.0.1-SNAPSHOT
$ kubectl get deployments.apps
$ kubectl get pod
$ kubectl get service catalog-service
$ kubectl port-forward catalog-service-647bcdbc78-g8z7d 8000:8080
$ http :8000
```


```bash

$ ./gradlew bootRun

$ http POST :9001/books author="Sarath P S" title="My Book" isbn="1234567656" price=9.45
HTTP/1.1 201 
Connection: keep-alive
Content-Length: 0
Date: Wed, 14 Jun 2023 16:27:00 GMT
Keep-Alive: timeout=15



$ http  :9001/books
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Wed, 14 Jun 2023 16:28:12 GMT
Keep-Alive: timeout=15
Transfer-Encoding: chunked

[
    {
        "author": "Sarath P S",
        "isbn": "1234567656",
        "price": 9.45,
        "title": "My Book"
    }
]

❯ http  :9001/books/1234567656
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Wed, 14 Jun 2023 16:28:25 GMT
Keep-Alive: timeout=15
Transfer-Encoding: chunked

{
    "author": "Sarath P S",
    "isbn": "1234567656",
    "price": 9.45,
    "title": "My Book"
}

