[int]$numero =  Read-Host "Introduce un numero"
for($i=0; $i -le 10; $i++){
    $resultado = $numero*$i
    Write-Host "$numero*$i=$resultado"
}