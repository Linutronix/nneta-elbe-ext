DEPENDS = "libgpio"

SRC_URI = "git://github.com/manut/hello"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit pbuilder
