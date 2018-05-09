
# bb file demonstrating usage of orig file

# use elbe pbuilder to build the debian package.
inherit pbuilder


LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;beginline=8;md5=3a34942f4ae3fbf1a303160714e664ac"

DEBMIRROR ?= "http://security.debian.org/debian-security"

# prefer snapshot.debian.org, because it will not go away.
DEBMIRROR = "http://snapshot.debian.org/archive/debian-security/20180314T212509Z"

# specify versions
UPSTREAM_VERSION = "7.52.1"
DEB_REV = "5+deb9u5"
PN_DEBPATH = "${BPN}"
BASE_DEBPATH = "${DEBMIRROR}/pool/updates/main/c/curl/${PN_DEBPATH}_${UPSTREAM_VERSION}"
UPSTREAM_DIR = "${PN_DEBPATH}-${UPSTREAM_VERSION}"

# now use SRC_URI to unpack orig.tar.xz and debian.tar.xz
# also specify orig.tar.xz again with unpack=false, so that we can pass it
# to elbe pbuilder.

SRC_URI = " \
	${BASE_DEBPATH}.orig.tar.gz;name=upstream \
	${BASE_DEBPATH}.orig.tar.gz;name=upstream2;unpack=false \
	${BASE_DEBPATH}-${DEB_REV}.debian.tar.xz;name=debian;subdir=${UPSTREAM_DIR} \
	"

SRC_URI[upstream.md5sum] = "4e1ef056e117b4d25f4ec42ac609c0d4"
SRC_URI[upstream2.md5sum] = "4e1ef056e117b4d25f4ec42ac609c0d4"
SRC_URI[debian.md5sum] = "00decba9cc904c141da756ee4ba1cf12"
SRC_URI[dsc.md5sum] = "b76a461cdb07f5990c64f026ad581588"

SRC_URI[upstream.sha256sum] = "a8984e8b20880b621f61a62d95ff3c0763a3152093a9f9ce4287cfd614add6ae"
SRC_URI[upstream2.sha256sum] = "a8984e8b20880b621f61a62d95ff3c0763a3152093a9f9ce4287cfd614add6ae"
SRC_URI[debian.sha256sum] = "2f0335ccf140637f0fb11b7a139e3faf8d94dab88603233d22689e4e6b6dce77"
SRC_URI[dsc.sha256sum] = "7a056c950e8e1bc29c1c4274c5eb15e8e1f5aa11fb19f592f85c1abf231701bd"


S = "${WORKDIR}/${UPSTREAM_DIR}"

# and finally demonstrate how ORIG_FILE can be used to
# pass a value to elbe pbuilder --origfile "${ORIG_FILE}
ORIG_FILE = "${WORKDIR}/${PN_DEBPATH}_${UPSTREAM_VERSION}.orig.tar.gz"
