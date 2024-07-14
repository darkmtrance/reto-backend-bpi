#!/bin/bash

echo "Construyendo la imagen Docker para oauth-server..."

cd oauth-server

docker build -t oauth-server:latest .

if [ $? -eq 0 ]; then
  echo "Imagen Docker construida exitosamente: oauth-server:latest"
else
  echo "Error al construir la imagen Docker"
fi