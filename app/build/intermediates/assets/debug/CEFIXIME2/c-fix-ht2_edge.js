/**
 * Adobe Edge: symbol definitions
 */
(function($, Edge, compId){
//images folder
var im='images/';

var fonts = {};
var opts = {
    'gAudioPreloadPreference': 'auto',

    'gVideoPreloadPreference': 'auto'
};
var resources = [
];
var symbols = {
"stage": {
    version: "4.0.0",
    minimumCompatibleVersion: "4.0.0",
    build: "4.0.0.359",
    baseState: "Base State",
    scaleToFit: "width",
    centerStage: "both",
    initialState: "Base State",
    gpuAccelerate: false,
    resizeInstances: false,
    content: {
            dom: [
            {
                id: 'bg2',
                type: 'image',
                rect: ['0', '0','1280px','727px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"bg.jpg",'0px','0px']
            },
            {
                id: 'taxt_22',
                type: 'image',
                rect: ['205px', '557px','721px','137px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"taxt_2.png",'0px','0px']
            },
            {
                id: 'top_patch_ht2',
                type: 'image',
                rect: ['0', '0','1280px','194px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"top_patch_ht2.png",'0px','0px']
            },
            {
                id: 'middle_ht2',
                type: 'image',
                rect: ['0', '183px','1280px','368px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"middle_ht2.png",'0px','0px']
            },
            {
                id: 'medicin1_ht2',
                type: 'image',
                rect: ['624px', '140px','438px','401px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"medicin1_ht2.png",'0px','0px']
            },
            {
                id: 'medicin2_ht2',
                type: 'image',
                rect: ['874px', '219px','364px','442px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"medicin2_ht2.png",'0px','0px']
            }],
            symbolInstances: [

            ]
        },
    states: {
        "Base State": {
            "${_medicin2_ht2}": [
                ["style", "top", '219px'],
                ["style", "opacity", '0'],
                ["style", "left", '920px']
            ],
            "${_middle_ht2}": [
                ["style", "top", '183px'],
                ["style", "opacity", '0'],
                ["style", "left", '40px']
            ],
            "${_Stage}": [
                ["color", "background-color", 'rgba(0,0,0,1.00)'],
                ["style", "width", '1280px'],
                ["style", "height", '727px'],
                ["style", "overflow", 'hidden']
            ],
            "${_top_patch_ht2}": [
                ["style", "top", '-20px'],
                ["style", "opacity", '0'],
                ["style", "left", '0px']
            ],
            "${_medicin1_ht2}": [
                ["style", "top", '140px'],
                ["style", "opacity", '0'],
                ["style", "left", '700px']
            ],
            "${_taxt_22}": [
                ["style", "top", '580px'],
                ["style", "opacity", '0'],
                ["style", "left", '205px']
            ]
        }
    },
    timelines: {
        "Default Timeline": {
            fromState: "Base State",
            toState: "",
            duration: 1085,
            autoPlay: true,
            timeline: [
                { id: "eid88", tween: [ "style", "${_taxt_22}", "top", '557px', { fromValue: '580px'}], position: 250, duration: 250, easing: "easeOutBounce" },
                { id: "eid136", tween: [ "style", "${_medicin2_ht2}", "left", '874px', { fromValue: '920px'}], position: 835, duration: 250, easing: "easeOutBounce" },
                { id: "eid137", tween: [ "style", "${_medicin2_ht2}", "opacity", '1', { fromValue: '0'}], position: 835, duration: 250, easing: "easeOutBounce" },
                { id: "eid116", tween: [ "style", "${_top_patch_ht2}", "opacity", '1', { fromValue: '0'}], position: 65, duration: 230, easing: "easeOutBounce" },
                { id: "eid125", tween: [ "style", "${_middle_ht2}", "opacity", '1', { fromValue: '0'}], position: 455, duration: 240, easing: "easeOutBounce" },
                { id: "eid124", tween: [ "style", "${_middle_ht2}", "left", '0px', { fromValue: '40px'}], position: 455, duration: 240, easing: "easeOutBounce" },
                { id: "eid131", tween: [ "style", "${_medicin1_ht2}", "opacity", '1', { fromValue: '0'}], position: 640, duration: 245, easing: "easeOutBounce" },
                { id: "eid130", tween: [ "style", "${_medicin1_ht2}", "left", '624px', { fromValue: '700px'}], position: 640, duration: 245, easing: "easeOutBounce" },
                { id: "eid86", tween: [ "style", "${_taxt_22}", "opacity", '1', { fromValue: '0'}], position: 250, duration: 250, easing: "easeOutBounce" },
                { id: "eid119", tween: [ "style", "${_top_patch_ht2}", "top", '0px', { fromValue: '-20px'}], position: 65, duration: 230, easing: "easeOutBounce" }            ]
        }
    }
}
};


Edge.registerCompositionDefn(compId, symbols, fonts, resources, opts);

/**
 * Adobe Edge DOM Ready Event Handler
 */
$(window).ready(function() {
     Edge.launchComposition(compId);
});
})(jQuery, AdobeEdge, "EDGE-103569781");
