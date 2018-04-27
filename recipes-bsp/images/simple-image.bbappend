# take care the binary packages might have other names than the .bb recipes
IMAGE_INSTALL += "hello=0.1+g7f35942-1 libgpio1 bla-file"
# list of .bb recipes that should be build
PACKAGE_BUILD += "hello libgpio bla-file"

image_postprocess() {
    echo "hello" > /etc/test
    image_groupadd grumpy "--gid 0"
    image_useradd dev "--uid 0 --gid 0 --home-dir /root --shell /bin/sh -G grumpy" dev
}
