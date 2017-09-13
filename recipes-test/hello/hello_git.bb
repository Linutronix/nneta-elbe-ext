DEPENDS = "libgpio"

SRC_URI = "git://github.com/ilbers/hello"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit pbuilder
