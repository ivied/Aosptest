/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.sblo.pandora.jota.text.style;

import android.os.Parcel;
import android.text.ParcelableSpan;

import jp.sblo.pandora.jota.text.Layout;
import jp.sblo.pandora.jota.text.TextUtils;

public interface AlignmentSpan extends ParagraphStyle {
    public Layout.Alignment getAlignment();

    public static class Standard
    implements AlignmentSpan, ParcelableSpan {
        public Standard(Layout.Alignment align) {
            mAlignment = align;
        }

        public Standard(Parcel src) {
            mAlignment = Layout.Alignment.valueOf(src.readString());
        }

        public int getSpanTypeId() {
            return TextUtils.ALIGNMENT_SPAN;
        }

        public int getSpanTypeIdInternal() {
            return android.text.TextUtils.ALIGNMENT_SPAN;
        }

        public void writeToParcelInternal(Parcel dest, int flags) {
            dest.writeString(mAlignment.name());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(mAlignment.name());
        }

        public Layout.Alignment getAlignment() {
            return mAlignment;
        }

        private final Layout.Alignment mAlignment;
    }
}
