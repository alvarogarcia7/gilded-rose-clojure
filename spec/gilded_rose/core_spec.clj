(ns gilded-rose.core-spec
(:require [speclj.core :refer :all]
          [gilded-rose.core :refer [update-quality item]]))

(describe "canary test"
  (it "the framework should work"
       (should true)))

(defn pass-days [n inventory]
  (nth (iterate update-quality inventory) n))

(let [sulfuras [(item "Sulfuras, Hand of Ragnaros" 0 80)]]
(describe "gilded rose"
  (it "should not affect legendary items"
       (should= sulfuras (pass-days 1 sulfuras)))))
