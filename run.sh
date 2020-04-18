cd out

export OUT_DIR=../out
export TERMINAL_WIDTH=$(tput cols)
export TERMINAL_HEIGHT=$(tput lines)

java -cp $OUT_DIR jlearn.Main $TERMINAL_WIDTH $TERMINAL_HEIGHT git-bash

cd ..