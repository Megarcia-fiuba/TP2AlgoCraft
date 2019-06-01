Ejemplo                                                                                                                                                                 
==========

Este proyecto es un simple ejemplo que muestra un proyecto base en Java para la material Algo3.

## Definición de pruebas
### Nombrar correctamente los archivos de pruebas

Al momento de definir un nuevo archivo que contendrá pruebas, ya sean unitarias o de integración, el patrón del nuevo archivo **deberá** ser `*Test.java`; además de ubicarse en `<directorio del proyecto>/test/`. A modo de ejemplo: `<mi proyecto>/test/<paquete>/MiNuevoArchivoTest.java`.


## Como bajarse el proyecto y hacer commit

abrir git bash o la consola de linux en donde sea tu proyecto local

ejecutar el comando `git clone https://github.com/Megarcia-fiuba/TP2AlgoCraft.git` 

se descargara el proyecto

Para hacer commit

ejecutar el comando `git status` para ver que archivos fueron modificados

en verde se ven archivos modificados y en rojo archivos a agregar. 

si alguno de los archivos a agregar no deberia subirse al repositorio(.jar .class cosas del IDE) agreguen el nombre de este al archivo gitignore, si son varios de misma extencion se puede agregar asi a todos: `*.extencion` 

para agregar archivos a subir: `git add <archivo>`
para agregar todos los archivos que no estan: `git add .`

se debe hacer un  `git pull` para bajar algun cambio que haya en el repositorio remoto

si hay algun conflicto deben resolverlo.

luego de realizar los cambios y agregar los archivos se debe realizar el commit localmente de la siguiente forma 
`git commit -m '<Comentario sobre el commit>' ` 

ahora se pueden subir los cambios con el comando `git push`
