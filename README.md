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
