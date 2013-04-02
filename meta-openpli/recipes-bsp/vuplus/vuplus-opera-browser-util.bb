DESCRIPTION = "opera-hbbtv-browser"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

DEPENDS = "tslib mpfr gmp"

SRC_DATE = "20130122_0"
SRC_URI = "http://code.vuplus.com/download/build.fc3abf29fb03f797e78f907928125638/embedded/opera-sdk-build-package/opera-hbbtv_${SRC_DATE}.tar.gz"

PR = "r3_${SRC_DATE}"

S = "${WORKDIR}/opera-hbbtv"

do_install() {
	install -d ${D}/usr
	install -d ${D}/usr/local
	install -d ${D}/usr/local/hbb-browser

	mv ${S}/opera/lib/libopera.so ${S}/opera/lib/libopera.so.0
	cp -avR ${S}/opera/* ${D}/usr/local/hbb-browser/

	install -d ${D}/etc
	cp -avR ${S}/dfb/etc/* ${D}/etc/

	install -d ${D}/usr/bin
	cp -avR ${S}/dfb/usr/bin/* ${D}/usr/bin/

	install -d ${D}/usr/lib
	cp -avR ${S}/dfb/usr/lib/* ${D}/usr/lib/

	install -d ${D}/usr/share
	cp -avR ${S}/dfb/usr/share/* ${D}/usr/share/

	install -d ${D}/usr/lib/enigma2
	install -d ${D}/usr/lib/enigma2/python
	install -d ${D}/usr/lib/enigma2/python/Plugins
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/HbbTV
	cp -avR ${S}/plugin/* ${D}/usr/lib/enigma2/python/Plugins/Extensions/HbbTV
}

INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} = "/usr/lib /usr/local /usr/share /usr/bin /etc "
PACKAGES = "${PN}"
PROVIDES="${PACKAGES}"
PACKAGE_ARCH := "${MACHINE_ARCH}"

SRC_URI[md5sum] = "3b437bb48e9724b1df1224afb733a5a6"
SRC_URI[sha256sum] = "f83161b34cf32d0190533195c0d27d2f4e3110d9bb315822db233dcc00760192"
