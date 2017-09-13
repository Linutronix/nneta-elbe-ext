# take care the binary packages might have other names than the .bb recipes
IMAGE_INSTALL += "hello libgpio1"
# list of .bb recipes that should be build
PACKAGE_BUILD += "hello libgpio"
