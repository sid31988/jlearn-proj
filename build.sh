echo "Clean previous build"
cd out
rm -rf jlearn
cd ../jlearn

export OUT_DIR=../out
export _javac="javac -cp $OUT_DIR -d $OUT_DIR"

echo "Building the project"
$_javac ./util/StringHelper.java
$_javac ./ui/util/UiHelper.java
$_javac ./ui/pages/components/Renderable.java
$_javac ./ui/pages/components/Header.java
$_javac ./ui/pages/Page.java
$_javac ./ui/UiController.java
$_javac ./variables/VariablesSample.java
$_javac Main.java

cd ..