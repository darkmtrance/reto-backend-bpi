#!/bin/bash

echo "Construyendo la imagen Docker para ms-cliente..."

cd ms-cliente

docker build -t ms-cliente:latest .

if [ $? -eq 0 ]; then
  echo "Imagen Docker construida exitosamente: ms-cliente:latest"
else
  echo "Error al construir la imagen Docker"
fi