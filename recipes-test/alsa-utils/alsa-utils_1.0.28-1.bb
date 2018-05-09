
# bb file demonstrating usage of orig file

# use elbe pbuilder to build the debian package.
inherit pbuilder

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833 \
                    file://alsactl/utils.c;beginline=1;endline=20;md5=fe9526b055e246b5558809a5ae25c0b9"

DEBMIRROR ?= "http://deb.debian.org/debian"

# prefer snapshot.debian.org, because it will not go away.
DEBMIRROR = "http://snapshot.debian.org/archive/debian/20140708T162310Z"

# specify versions
UPSTREAM_VERSION = "1.0.28"
DEB_REV = "1"
PN_DEBPATH = "${BPN}"
BASE_DEBPATH = "${DEBMIRROR}/pool/main/a/alsa-utils/${PN_DEBPATH}_${UPSTREAM_VERSION}"
UPSTREAM_DIR = "${PN_DEBPATH}-${UPSTREAM_VERSION}"

# now use SRC_URI to unpack orig.tar.xz and debian.tar.xz
# also specify orig.tar.xz again with unpack=false, so that we can pass it
# to elbe pbuilder.

SRC_URI = " \
	${BASE_DEBPATH}.orig.tar.bz2;name=upstream \
	${BASE_DEBPATH}.orig.tar.bz2;name=upstream2;unpack=false \
	${BASE_DEBPATH}-${DEB_REV}.debian.tar.xz;name=debian;subdir=${UPSTREAM_DIR} \
	"

SRC_URI[upstream.md5sum] = "361552d5b1cacd0a1e7ba09e69990211"
SRC_URI[upstream2.md5sum] = "361552d5b1cacd0a1e7ba09e69990211"
SRC_URI[debian.md5sum] = "48d2d9788d1b9968af3a55e33dd4bb07"
SRC_URI[dsc.md5sum] = "2a221e0671d622cc508c5a778319848a"

SRC_URI[upstream.sha256sum] = "f3ff4c89b0125a7797b1b13cd094cc92276e655458274967386e812d03642acc"
SRC_URI[upstream2.sha256sum] = "f3ff4c89b0125a7797b1b13cd094cc92276e655458274967386e812d03642acc"
SRC_URI[debian.sha256sum] = "ed830899479ab397e0a49697d479c24988e037a18914ae0efc02206d650777f2"
SRC_URI[dsc.sha256sum] = "e9ce19a44642f0766fe32118f54c6463d90706aacfc0ea5293da2884744d7ee8"


S = "${WORKDIR}/${UPSTREAM_DIR}"

# and finally demonstrate how ORIG_FILE can be used to
# pass a value to elbe pbuilder --origfile "${ORIG_FILE}
ORIG_FILE = "${WORKDIR}/${PN_DEBPATH}_${UPSTREAM_VERSION}.orig.tar.bz2"
