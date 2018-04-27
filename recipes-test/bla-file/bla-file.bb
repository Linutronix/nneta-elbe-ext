# Copyright (C) 2018 Torben Hohn <torben.hohn@linutronix.de>
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "MIT"

INHIBIT_DEFAULT_DEPS = "1"

do_install () {
    mkdir -p ${D}/etc
    echo "bla" > ${D}/etc/bla
}

PACKAGES = "${PN}"
