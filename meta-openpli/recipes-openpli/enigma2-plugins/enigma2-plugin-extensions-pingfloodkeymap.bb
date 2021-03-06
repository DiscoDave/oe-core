DESCRIPTION = "KeyMap by Ping Flood"
RDEPENDS = "enigma2"
DEPENDS = "python-native"
PACKAGE_ARCH = "${MACHINE_ARCH}"
LICENSE = "CLOSED"

SRCREV_pn-${PN} ?= "${AUTOREV}"

inherit gitpkgv pkgconfig

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r4"

SRC_URI = "git://github.com/persianpros/pingfloodkeymap-plugin.git;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
	python -O -m compileall ${S}
}

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
}

do_install() {
	install -d  ${D}/usr/lib/enigma2/python/Plugins/Extensions/Keymap_by_PingFlood
	
	install -m 0644 ${S}/*.pyo \
	${D}/usr/lib/enigma2/python/Plugins/Extensions/Keymap_by_PingFlood

	install -m 0644 ${S}/plugin.png \
	${D}/usr/lib/enigma2/python/Plugins/Extensions/Keymap_by_PingFlood

        install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/Keymap_by_PingFlood/img/
        install -m 0644 ${S}/img/*.png ${D}/usr/lib/enigma2/python/Plugins/Extensions/Keymap_by_PingFlood/img/

        install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/Keymap_by_PingFlood/xml/
        install -m 0644 ${S}/xml/*.xml ${D}/usr/lib/enigma2/python/Plugins/Extensions/Keymap_by_PingFlood/xml/
}

FILES_enigma2-plugin-extensions-pingfloodkeymap = "/usr/lib/enigma2/python/Plugins/Extensions/Keymap_by_PingFlood"

PACKAGES = "enigma2-plugin-extensions-pingfloodkeymap"

PROVIDES="${PACKAGES}"
