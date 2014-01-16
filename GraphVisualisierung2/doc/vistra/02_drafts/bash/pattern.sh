#!/bin/bash
PATTERN="Pattern"
echo PATTERN
echo "---------------------------"
for i in "Factory" "State" "Command" ; do
	echo $i"-"$PATTERN":";
	./greptree.sh $i;
	echo
done

