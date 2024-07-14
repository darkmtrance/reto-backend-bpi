#!/bin/bash

echo "Construyendo la imagen Docker para ms-producto..."

cd ms-producto

docker build -t ms-producto:latest .

if [ $? -eq 0 ]; then
  echo "Imagen Docker construida exitosamente: ms-producto:latest"
else
  echo "Error al construir la imagen Docker"
fi