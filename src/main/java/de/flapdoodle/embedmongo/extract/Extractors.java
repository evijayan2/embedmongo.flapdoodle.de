/**
 * Copyright (C) 2011
 *   Michael Mosmann <michael@mosmann.de>
 *   Martin Jöhren <m.joehren@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.embedmongo.extract;

import de.flapdoodle.embedmongo.Paths;
import de.flapdoodle.embedmongo.distribution.ArchiveType;
import de.flapdoodle.embedmongo.distribution.Distribution;

/**
 * Extractor Helper
 */
public class Extractors {
	private Extractors() {

	}

	public static IExtractor getExtractor(Distribution distribution) {
		ArchiveType archiveType = Paths.getArchiveType(distribution);
		switch (archiveType) {
			case TGZ:
				return new TgzExtractor();
			case ZIP:
				return new ZipExtractor();
			default:
				throw new IllegalArgumentException("ArciveType " + archiveType + " not supported");
		}
	}
}
