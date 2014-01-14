#!bin/bash
for dir in ???\(1\)/; do
    base=${dir%(*}
    for i in 1 2; do
        f=${base}_S1_L001_R${i}_001.fastq
        echo "mv ${base}/$f ${base}/$f.bak"
        echo "cat ${base}*/${f}* > tutti.txt"
    done
done
