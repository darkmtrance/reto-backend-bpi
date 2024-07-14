#!/bin/bash

echo "Construyendo la imagen Docker para spring-gateway..."

cd spring-gateway

docker build -t spring-gateway:latest .

if [ $? -eq 0 ]; then
  echo "Imagen Docker construida exitosamente: spring-gateway:latest"
else
  echo "Error al construir la imagen Docker"
fi